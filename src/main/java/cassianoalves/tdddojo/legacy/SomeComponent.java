package cassianoalves.tdddojo.legacy;

public class SomeComponent {

    public int multiplyByFactorOfCode(int code, int value) {
        FactorDao dao = FactorDaoFactory.getInstance();
        int factor = dao.getFactor(code);

        return value * factor;
    }
}
