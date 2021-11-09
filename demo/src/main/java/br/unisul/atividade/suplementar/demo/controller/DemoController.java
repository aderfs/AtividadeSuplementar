package br.unisul.atividade.suplementar.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    public Double DescontoINSS(Double bruto){

        Double INSS = 0.0;

        if (bruto < 429.00) {
            INSS = bruto * (0.0765);
        } else if (bruto >= 429.00 && bruto < 540.00) {
            INSS = bruto * (0.0865);
        } else if (bruto >= 540.00 && bruto < 715.00) {
            INSS = bruto * (0.0900);
        } else if (bruto >= 715.00 && bruto < 1430.00) {
            INSS = bruto * (0.1100);
        } else if (bruto >= 1430.00) {
            INSS = 157.00;
        }
        return INSS;
    }
    
    public Double DescontoIRRF(Double bruto, Double INSS){

        Double IRRF = 0.0;
        Double brutoINSS = bruto - INSS;

        if (brutoINSS < 1058.00) {
            IRRF = brutoINSS * (0.000);
        } else if (brutoINSS >= 1058.00 && bruto < 2115.00) {
            IRRF = brutoINSS * (0.15);
        } else if (brutoINSS >= 2115.00) {
            IRRF = brutoINSS * (0.275);
        }
        return IRRF;
    }

    public Double SalarioLiquido(Double bruto, Double INSS, Double IRRF){

        Double liquido = bruto - INSS - IRRF;

        return liquido;
    }

    @GetMapping("/{bruto}")
    public String getDados(@PathVariable(name = "bruto") Double bruto){

        Double INSS = DescontoINSS(bruto);
        Double IRRF = DescontoIRRF(bruto, INSS);
        Double liquido = SalarioLiquido(bruto, INSS, IRRF);

        String demo = "O Salário bruto dado foi de: " + Double.toString(bruto)
                    + "\nO Desconto do INSS foi de: " + Double.toString(INSS)
                    + "\nO Desconto do IRRF foi de: " + Double.toString(IRRF)
                    + "\nO Salário liquido foi de: " + Double.toString(liquido);

        return demo;
    }
}
