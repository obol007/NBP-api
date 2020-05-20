package pl.obol.nbpapi.exchange;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Controller
@AllArgsConstructor
@Slf4j
public class RateController {

    private final ExchangeRate exchangeRate;

    @RequestMapping("/")
    @ResponseBody
    public String getConcurrencyTable(){
        TableDto[] body=exchangeRate.getDataFromTable();

       return Arrays.toString(Arrays.stream(body).map(TableDto::getRates)
               .map(e -> String.format("\n  '%s'", e))
               .toArray());

//        return Arrays.toString(body);
    }

}
