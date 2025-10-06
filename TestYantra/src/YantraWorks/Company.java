package YantraWorks;

class Company {
    String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void displayCompanyInfo() {
        System.out.println("Welcome to " + companyName + " Pvt Ltd");
    }
}