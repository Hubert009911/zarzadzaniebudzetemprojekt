package am.jsl.personalfinances.web.controller.currency;

import am.jsl.personalfinances.dto.Pair;
import am.jsl.personalfinances.service.currency.CurrencyService;
import am.jsl.personalfinances.util.TextUtils;
import am.jsl.personalfinances.web.controller.BaseController;
import am.jsl.personalfinances.web.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Definiuje metody konwersji walut.
 */
@Controller
@RequestMapping(value = "/currency")
@Lazy
public class CurrencyController extends BaseController {
    /**
     * Usługa walutowa
     */
    @Autowired
    private transient CurrencyService currencyService;

    /**
     * Konwertuje podaną kwotę z waluty źródłowej na walutę docelową.
     * @param amount kwota
     * @param from waluta źródłowa
     * @param to waluta docelowa
     * @return JSON zawierający parę kursów, przeliczoną kwotę
     */
    @RequestMapping(value = {"/convert"}, method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse convert(@RequestParam(value = "amount") double amount,
                         @RequestParam(value = "from") String from,
                         @RequestParam(value = "to") String to) {
        JsonResponse response = new JsonResponse();

        if (!TextUtils.isEmpty(from) && !TextUtils.isEmpty(to)) {
            double rate = currencyService.getRate(from, to);
            amount =  amount * rate;

            Pair<Double, Double> rateAmount = new Pair<>(rate, amount);
            response.setResult(rateAmount);
        }

        return response;
    }

    /**
     * Przelicza podaną kwotę na podaną stawkę.
     * @param amount kwota
     * @param rate stawka
     * @return przeliczona kwota
     */
    @RequestMapping(value = {"/convertWithRate"}, method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse convertWithRate(@RequestParam(value = "amount") double amount,
                         @RequestParam(value = "rate") double rate) {
        JsonResponse response = new JsonResponse();
        response.setResult(amount * rate);
        return response;
    }
}
