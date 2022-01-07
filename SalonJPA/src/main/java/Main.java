
import org.salon.models.*;
import org.salon.repos.*;

import static org.salon.repos.CategorieProdusUtils.findCategorieProdus;
import static org.salon.repos.IncasareUtils.addIncasare;
import static org.salon.repos.IncasareUtils.findIncasare;
import static org.salon.repos.ProdusUtils.findProdus;
import static org.salon.repos.ServiciuUtils.addServiciu;
import static org.salon.repos.ServiciuUtils.findServiciu;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("Marcu", "Marta", "feminin", 21, 753073327);
        ClientUtils.addClient(client);
        Client client2 = new Client("Iliescu", "Diana", "feminin", 45, 753256527);
        ClientUtils.addClient(client2);
        Client client3 = new Client("Iosub", "Dan", "masculin", 50, 753146325);
        ClientUtils.addClient(client3);
        Client client4 = new Client("Timofte", "Dumitru", "masculin", 18, 725896347);
        ClientUtils.addClient(client4);
        Client client5 = new Client("Maftei", "Lucian", "masculin", 31, 774523685);
        ClientUtils.addClient(client5);


        Programare programare = new Programare("01-01-2022", false);
        ProgramareUtils.addProgramare(programare);
        Programare programare2 = new Programare("05-02-2022", true);
        ProgramareUtils.addProgramare(programare2);
        Programare programare3 = new Programare("09-01-2022", true);
        ProgramareUtils.addProgramare(programare3);
        Programare programare4 = new Programare("10-01-2022", false);
        ProgramareUtils.addProgramare(programare4);
        Programare programare5 = new Programare("18-01-2022", false);
        ProgramareUtils.addProgramare(programare5);

        Angajat angajat = new Angajat("Popescu", "Maria", "feminin", 35, 753073327, "01-01-2022");
        AngajatUtils.addAngajat(angajat);
        Angajat angajat2 = new Angajat("Irimia", "Daniel", "masculin", 27, 785427632, "28-09-2021");
        AngajatUtils.addAngajat(angajat2);
        Angajat angajat3 = new Angajat("Roman", "Andreea", "feminin", 40, 754713456, "10-11-2019");
        AngajatUtils.addAngajat(angajat3);
        Angajat angajat4 = new Angajat("Zota", "Diana", "feminin", 25, 747521453, "01-06-2021");
        AngajatUtils.addAngajat(angajat4);
        Angajat angajat5 = new Angajat("Maxim", "Eusebiu", "masculin", 41, 774256325, "21-05-2020");
        AngajatUtils.addAngajat(angajat5);

        Salariu salariu = new Salariu(1400, "01-01-2022", "CASH");
        SalariuUtils.addSalariu(salariu);
        Salariu salariu2 = new Salariu(2200, "08-12-2021", "CARD");
        SalariuUtils.addSalariu(salariu2);
        Salariu salariu3 = new Salariu(2100, "08-12-2021", "CASH");
        SalariuUtils.addSalariu(salariu3);
        Salariu salariu4 = new Salariu(1800, "30-12-2021", "CARD");
        SalariuUtils.addSalariu(salariu4);

        CategorieProdus categorieProdus = new CategorieProdus("Vopsea");
        CategorieProdusUtils.addCategorieProdus(categorieProdus);
        CategorieProdus categorieProdus2 = new CategorieProdus("Decolorant");
        CategorieProdusUtils.addCategorieProdus(categorieProdus2);
        CategorieProdus categorieProdus3 = new CategorieProdus("Styling");
        CategorieProdusUtils.addCategorieProdus(categorieProdus3);
        CategorieProdus categorieProdus4 = new CategorieProdus("Tratament");
        CategorieProdusUtils.addCategorieProdus(categorieProdus4);

        Produs produs = new Produs("Vopsea Blond", "WELLA", 30, "01-01-2023");
        ProdusUtils.addProdus(produs);
        Produs produs2 = new Produs(" Decolorant Vol 18%", "WELLA", 15, "18-01-2024");
        ProdusUtils.addProdus(produs2);
        Produs produs3 = new Produs("Ceara Shiny", "LONDA", 18, "25-12-2022");
        ProdusUtils.addProdus(produs3);
        Produs produs4 = new Produs("Vopsea Rosu", "WELLA", 40, "01-04-2023");
        ProdusUtils.addProdus(produs4);
        Produs produs5 = new Produs("Sampon Keratina", "SYOSS", 10, "28-01-2023");
        ProdusUtils.addProdus(produs5);

        Furnizor furnizor = new Furnizor("WELLA SA", "Strada Pomilor 5, Iasi");
        FurnizorUtils.addFurnizor(furnizor);
        Furnizor furnizor2 = new Furnizor("LONDA SRL", "Strada Florilor 18, Bucuresti");
        FurnizorUtils.addFurnizor(furnizor2);
        Furnizor furnizor3 = new Furnizor("SYOSS SA", "Strada Viticultorilor 20, Timisoara");
        FurnizorUtils.addFurnizor(furnizor3);
        Furnizor furnizor4 = new Furnizor("COSMETICLUX SRL", "Strada Ilie Voda 3, Arad");
        FurnizorUtils.addFurnizor(furnizor4);

        Ustensila ustensila = new Ustensila("FEON", "Rowenta", true);
        UstensilaUtils.addUstensila(ustensila);
        Ustensila ustensila2 = new Ustensila("PLACA PAR", "Rowenta", true);
        UstensilaUtils.addUstensila(ustensila2);
        Ustensila ustensila3 = new Ustensila("BIGUDIURI", "WELLA", false);
        UstensilaUtils.addUstensila(ustensila3);
        Ustensila ustensila4 = new Ustensila("FOARFECE", "LONDA", false);
        UstensilaUtils.addUstensila(ustensila4);
        Ustensila ustensila5 = new Ustensila("ONDULATOR", "Rowenta", true);
        UstensilaUtils.addUstensila(ustensila5);

        Serviciu serviciu = new Serviciu("Vopsit", 3);
        addServiciu(serviciu);
        Serviciu serviciu2 = new Serviciu("Tuns", 1);
        addServiciu(serviciu2);
        Serviciu serviciu3 = new Serviciu("Coafat", 2);
        addServiciu(serviciu3);
        Serviciu serviciu4 = new Serviciu("Spalat", 1);
        addServiciu(serviciu4);
        Serviciu serviciu5 = new Serviciu("Suvitat", 4);
        addServiciu(serviciu5);

        Incasare incasare = new Incasare(400, "24-12-2021");
        addIncasare(incasare);
        Incasare incasare2 = new Incasare(100, "31-12-2021");
        addIncasare(incasare2);
        Incasare incasare3 = new Incasare(150, "01-01-2022");
        addIncasare(incasare3);
        Incasare incasare4 = new Incasare(80, "02-01-2022");
        addIncasare(incasare4);
        Incasare incasare5 = new Incasare(50, "03-01-2022");
        addIncasare(incasare5);

        Client client1 = ClientUtils.findClient(1);
        Programare programare1 = ProgramareUtils.findProgramare(6);
        client1.addProgramare(programare1);
        ClientUtils.updateClient(client1);

        Angajat angajat1 = AngajatUtils.findAngajat(11);
        angajat1.addProgramare(programare1);

        angajat1.setSalariu(SalariuUtils.findSalariu(16));
        AngajatUtils.updateAngajat(angajat1);

        Client client6 = ClientUtils.findClient(2);
        Programare programare6 = ProgramareUtils.findProgramare(7);
        client6.addProgramare(programare6);
        ClientUtils.updateClient(client6);

        Angajat angajat6 = AngajatUtils.findAngajat(12);
        angajat6.addProgramare(programare6);

        angajat6.setSalariu(SalariuUtils.findSalariu(17));
        AngajatUtils.updateAngajat(angajat6);

        Client client7 = ClientUtils.findClient(3);
        Programare programare7 = ProgramareUtils.findProgramare(8);
        client7.addProgramare(programare7);
        ClientUtils.updateClient(client7);

        Angajat angajat7 = AngajatUtils.findAngajat(13);
        angajat7.addProgramare(programare7);

        angajat7.setSalariu(SalariuUtils.findSalariu(18));
        AngajatUtils.updateAngajat(angajat7);

        Client client8 = ClientUtils.findClient(4);
        Programare programare8 = ProgramareUtils.findProgramare(9);
        client8.addProgramare(programare8);
        ClientUtils.updateClient(client8);

        Angajat angajat8 = AngajatUtils.findAngajat(14);
        angajat8.addProgramare(programare8);

        angajat8.setSalariu(SalariuUtils.findSalariu(19));
        AngajatUtils.updateAngajat(angajat8);

        Client client9 = ClientUtils.findClient(5);
        Programare programare9 = ProgramareUtils.findProgramare(10);
        client7.addProgramare(programare9);
        ClientUtils.updateClient(client9);

        Angajat angajat9 = AngajatUtils.findAngajat(15);
        angajat9.addProgramare(programare9);

        angajat9.setSalariu(SalariuUtils.findSalariu(19));
        AngajatUtils.updateAngajat(angajat9);


        Produs produs1 = findProdus(24);
        CategorieProdus categorieProdus1 = findCategorieProdus(20);
        categorieProdus1.addProdus(produs1);
        CategorieProdusUtils.updateCategorieProdus(categorieProdus1);

        Produs produs6 = findProdus(25);
        CategorieProdus categorieProdus5 = findCategorieProdus(21);
        categorieProdus5.addProdus(produs6);
        CategorieProdusUtils.updateCategorieProdus(categorieProdus5);

        Produs produs7 = findProdus(26);
        CategorieProdus categorieProdus6 = findCategorieProdus(22);
        categorieProdus6.addProdus(produs7);
        CategorieProdusUtils.updateCategorieProdus(categorieProdus6);

        Produs produs8 = findProdus(27);
        CategorieProdus categorieProdus7 = findCategorieProdus(20);
        categorieProdus7.addProdus(produs8);
        CategorieProdusUtils.updateCategorieProdus(categorieProdus7);

        Produs produs9 = findProdus(28);
        CategorieProdus categorieProdus8 = findCategorieProdus(23);
        categorieProdus8.addProdus(produs9);
        CategorieProdusUtils.updateCategorieProdus(categorieProdus8);

        Ustensila ustensila1 = UstensilaUtils.findUstensila(33);
        Furnizor furnizor1 = FurnizorUtils.findFurnizor(32);
        furnizor1.addProdus(produs1);
        furnizor1.addUstensila(ustensila1);
        FurnizorUtils.updateFurnizor(furnizor1);


        Ustensila ustensila6 = UstensilaUtils.findUstensila(34);
        Furnizor furnizor5 = FurnizorUtils.findFurnizor(32);
        furnizor5.addProdus(produs6);
        furnizor5.addUstensila(ustensila6);
        FurnizorUtils.updateFurnizor(furnizor5);

        Ustensila ustensila7 = UstensilaUtils.findUstensila(35);
        Furnizor furnizor6 = FurnizorUtils.findFurnizor(29);
        furnizor6.addProdus(produs7);
        furnizor6.addUstensila(ustensila7);
        FurnizorUtils.updateFurnizor(furnizor6);


        Ustensila ustensila8 = UstensilaUtils.findUstensila(36);
        Furnizor furnizor7 = FurnizorUtils.findFurnizor(30);
        furnizor7.addProdus(produs8);
        furnizor7.addUstensila(ustensila8);
        FurnizorUtils.updateFurnizor(furnizor7);


        Ustensila ustensila9 = UstensilaUtils.findUstensila(37);
        Furnizor furnizor8 = FurnizorUtils.findFurnizor(32);
        furnizor8.addProdus(produs9);
        furnizor8.addUstensila(ustensila9);
        FurnizorUtils.updateFurnizor(furnizor8);


        Serviciu serviciu1 = findServiciu(38);
        programare1.addServiciu(serviciu1);
        ProgramareUtils.updateProgramare(programare1);

        Serviciu serviciu6 = findServiciu(39);
        programare6.addServiciu(serviciu6);
        ProgramareUtils.updateProgramare(programare6);

        Serviciu serviciu7 = findServiciu(40);
        programare7.addServiciu(serviciu7);
        ProgramareUtils.updateProgramare(programare7);

        Serviciu serviciu8 = findServiciu(41);
        programare8.addServiciu(serviciu8);
        ProgramareUtils.updateProgramare(programare8);

        Serviciu serviciu9 = findServiciu(42);
        programare9.addServiciu(serviciu9);
        ProgramareUtils.updateProgramare(programare9);

        Incasare incasare1 = findIncasare(43);
        programare1.setIncasare(incasare1);
        ProgramareUtils.updateProgramare(programare1);

        Incasare incasare6 = findIncasare(44);
        programare6.setIncasare(incasare6);
        ProgramareUtils.updateProgramare(programare6);

        Incasare incasare7 = findIncasare(45);
        programare7.setIncasare(incasare7);
        ProgramareUtils.updateProgramare(programare7);

        Incasare incasare8 = findIncasare(46);
        programare8.setIncasare(incasare8);
        ProgramareUtils.updateProgramare(programare8);

        Incasare incasare9 = findIncasare(47);
        programare9.setIncasare(incasare9);
        ProgramareUtils.updateProgramare(programare9);
    }
}
