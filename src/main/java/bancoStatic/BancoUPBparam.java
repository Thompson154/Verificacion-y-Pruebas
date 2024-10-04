package bancoStatic;

public class BancoUPBparam {
    private AfpServiceGlobal afpServiceGlobal;
    private AsfiServiceGlobal asfiService;
    private SegipServiceGlobal segipService;

    public BancoUPBparam(AfpServiceGlobal afpServiceGlobal, AsfiServiceGlobal asfiService, SegipServiceGlobal segipService) {
        this.afpServiceGlobal = afpServiceGlobal;
        this.asfiService = asfiService;
        this.segipService = segipService;
    }

    public String getAmountMoney(int ci, int amount) {
        if (segipService.isRealPerson(ci)) {
            if (asfiService.isAbleToGetCredit(ci)) {
                int basicAmount = afpServiceGlobal.getAmount(ci);
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
