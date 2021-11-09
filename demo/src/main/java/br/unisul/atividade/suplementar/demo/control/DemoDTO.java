package br.unisul.atividade.suplementar.demo.control;

public class DemoDTO {
    
    private Double Bruto;
    private Double Liquido;
    private Double INSS;
    private Double IRRF;


    public Double getBruto() {
        return this.Bruto;
    }

    public void setBruto(Double Bruto) {
        this.Bruto = Bruto;
    }

    public Double getLiquido() {
        return this.Liquido;
    }

    public void setLiquido(Double Liquido) {
        this.Liquido = Liquido;
    }

    public Double getINSS() {
        return this.INSS;
    }

    public void setINSS(Double INSS) {
        this.INSS = INSS;
    }

    public Double getIRRF() {
        return this.IRRF;
    }

    public void setIRRF(Double IRRF) {
        this.IRRF = IRRF;
    }


    public DemoDTO() {
    }

    public DemoDTO(Double Bruto, Double INSS, Double IRRF, Double Liquido){
        this.Bruto = Bruto;
        this.INSS = INSS;
        this.IRRF = IRRF;
        this.Liquido = Liquido;
    }

    public static DemoDTO demo(Double Bruto, Double INSS, Double IRRF, Double Liquido){
        DemoDTO demo = new DemoDTO(Bruto,INSS,IRRF,Liquido);

        return demo;
    }
}
