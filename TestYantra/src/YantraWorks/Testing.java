package YantraWorks;

class Testing extends Company {
    int employees;

    public Testing(String companyName, int employees) {
        super(companyName);
        this.employees = employees;
    }

    public void showDetails() {
        System.out.println("Testing Department has " + employees + " employees.");
    }
}
