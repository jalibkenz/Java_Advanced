package YantraWorks;

class Institute extends Company {
    int trainers;

    public Institute(String companyName, int trainers) {
        super(companyName);
        this.trainers = trainers;
    }

    public void showDetails() {
        System.out.println("Institute provides training with " + trainers + " trainers.");
    }
}
