package elenacusacortigosa;

import javax.swing.JOptionPane;

public class ParteB {
    public static void main(String[] args) {

        //Entrada de datos
        //Lunes
        String lunes = JOptionPane.showInputDialog("Introduce los productos totales reparados el lunes: ");
        int prodLunes = Integer.parseInt(lunes);
        String cLunes = JOptionPane.showInputDialog("Introduce cuánto vas a cobrar por reparación el lunes: ");
        double cobroLunes = Double.parseDouble(cLunes);

        //Martes
        String martes = JOptionPane.showInputDialog("Introduce los productos totales reparados el martes: ");
        int prodMartes = Integer.parseInt(martes);
        String cMartes = JOptionPane.showInputDialog("Introduce cuánto vas a cobrar por reparación el martes: ");
        double cobroMartes = Double.parseDouble(cMartes);

        //Miércoles
        String miercoles = JOptionPane.showInputDialog("Introduce los productos totales reparados el miércoles: ");
        int prodMiercoles = Integer.parseInt(miercoles);
        String cMiercoles = JOptionPane.showInputDialog("Introduce cuánto vas a cobrar por reparación el miércoles: ");
        double cobroMiercoles = Double.parseDouble(cMiercoles);

        //Jueves
        String jueves = JOptionPane.showInputDialog("Introduce los productos totales reparados el jueves: ");
        int prodJueves = Integer.parseInt(jueves);
        String cJueves = JOptionPane.showInputDialog("Introduce cuánto vas a cobrar por reparación el jueves: ");
        double cobroJueves = Double.parseDouble(cJueves);

        //Viernes
        String viernes = JOptionPane.showInputDialog("Introduce los productos totales reparados el viernes: ");
        int prodViernes = Integer.parseInt(viernes);
        String cViernes = JOptionPane.showInputDialog("Introduce cuánto vas a cobrar por reparación el viernes: ");
        double cobroViernes = Double.parseDouble(cViernes);

        //Operaciones para ver cuánto se ha cobrado cada día
        //Lunes
        float gananciasLunes = prodLunes * (float)cobroLunes;
        String totalLunes = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n
                """. formatted(gananciasLunes);
        System.out.printf(totalLunes);

        //Martes
        float gananciasMartes = prodMartes * (float)cobroMartes;
        String totalMartes = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n
                """. formatted(gananciasMartes);
        System.out.printf(totalMartes);

        //Miércoles
        float gananciasMiercoles = prodMiercoles * (float)cobroMiercoles;
        String totalMiercoles = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n
                """. formatted(gananciasMiercoles);
        System.out.printf(totalMiercoles);

        //Jueves
        float gananciasJueves = prodJueves * (float)cobroJueves;
        String totalJueves = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n
                """. formatted(gananciasJueves);
        System.out.printf(totalJueves);

        //Viernes
        float gananciasViernes = prodViernes * (float)cobroViernes;
        String totalViernes = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n 
                """. formatted(gananciasViernes);
        System.out.printf(totalViernes);

        //Ganancias semanales
        float gananciasSemana = gananciasLunes + gananciasMartes + gananciasMiercoles + gananciasJueves + gananciasViernes;
        String totalSemana = """
                El lunes has tenido unas ganancias 
                de: %.1f euros%n
                """. formatted(gananciasSemana);
        System.out.printf(totalSemana);
    
        // Comprobar si las ganancias semanales son más de 1000€ o menos de 100€
        boolean gananciasValidas = (gananciasSemana > 1000) || (gananciasSemana < 100);
        System.out.println("¿Las ganancias semanales son más de 1000€ o menos de 100€? " + gananciasValidas);
    }

}
