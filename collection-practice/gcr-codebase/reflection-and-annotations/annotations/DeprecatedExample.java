class LegacyAPI {
    // old method
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature");
    }

    // new method
    void newFeature() {
        System.out.println("New feature");
    }
}

public class DeprecatedExample {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   // shows warning as output
        api.newFeature();   // recommended
    }
}
