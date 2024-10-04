package calcService;

// DEV  upb

public class CalculatorAWS {
    CalcService calcService;

    public CalculatorAWS(){
        calcService = new CalcService();
    }

    // STEP 1
    public CalculatorAWS(CalcService calcService ){
        this.calcService = calcService;
    }

    // or STEP 1
    public void setCalcService(CalcService calcService ){
        this.calcService = calcService;
    }

    // nosotros queremos testear para el factorial
    public int getFact(int number){
        int f=1;
        for (int i = 1; i <= number; i++) {
            f = calcService.mul(f,i);
        }
        return f;
    }
}

