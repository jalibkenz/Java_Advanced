package YantraWorks;

class Development extends Company {
    int employees;

    public Development(String companyName, int employees) {
        super(companyName);
        this.employees = employees;
    }

    public void showDetails() {
        System.out.println("Development Department has " + employees + " employees.");
    }
}