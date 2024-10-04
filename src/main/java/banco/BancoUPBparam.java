package banco;

public class BancoUPBparam {
    private AfpService afpService;
    private AsfiService asfiService;
    private SegipService segipService;

    public BancoUPBparam(AfpService afpService, AsfiService asfiService, SegipService segipService) {
        this.afpService = afpService;
        this.asfiService = asfiService;
        this.segipService = segipService;
    }

    public String getAmountMoney(int ci, int amount) {
        if (segipService.isRealPerson(ci)) {
            if (asfiService.isAbleToGetCredit(ci)) {
                int basicAmount = afpService.getAmount(ci);
                int totalAmount = basicAmount * 3;
                return "se le puede realizar el prestamo: " + totalAmount;
            } else {
                return "usted no esta habilitado para prestamos";
            }
        } else {
            return "debe revisar su carnet de identidad";
        }
    }
}
