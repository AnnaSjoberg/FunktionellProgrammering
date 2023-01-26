package JDBC.övn1;

public class Dashboard {

    public Dashboard() throws InterruptedException {
        RepoInterface repo = new Repository();

        while (true){
            System.out.println("Number of elves: " + repo.getAllElves().size());
            System.out.println("Employee names: ");
            repo.getAllElves().forEach(elf -> System.out.println(elf.getId() +": "+ elf.getName()));
            System.out.println("Number of children: " + repo.getNumberOfChildren());
            System.out.println("Behaviour average: " + repo.getNicenessAverage());
            Thread.sleep(2000);
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Dashboard d = new Dashboard();
    }
}
