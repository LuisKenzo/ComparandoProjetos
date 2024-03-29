package agenda;
import agenda.Data;

public class Agenda {
  private String mes; //Testando git
  public Data[] datas;

  public Agenda(String mes) {
    setMes(mes);
    if(mes.equals("Janeiro") || mes.equals("Mar�o") || mes.equals("Maio") || mes.equals("Julho")
      || mes.equals("Agosto") || mes.equals("Outubro") || mes.equals("Dezembro")) {
        datas = new Data[31];
      } else if(mes.equals("Abril") || mes.equals("Junho") || mes.equals("Setembro") || mes.equals("Novembro")) {
        datas = new Data[30];
      } else if(mes.equals("Fevereiro")) {
        datas = new Data[28];
      } else {
        //exception
      }
  }
    
  public void setMes(String mes) {
    this.mes = mes;
  }
  
  public String getMes() {
    return mes;
  }

  public void imprimeVoos() {
    System.out.println("-------------------------------------------------------");
    System.out.println("V�os dispon�veis para" +getMes());
    for(int i = 0; i<datas.length; i++) {
      if(datas[i].numeroDeVoos > 0) {
        System.out.println("Dia" +i);
        datas[i].imprimeData();
      } else {
        System.out.println();
      }
    }
    System.out.println("-------------------------------------------------------");
  }
}
