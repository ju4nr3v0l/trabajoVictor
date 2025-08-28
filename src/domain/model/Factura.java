package domain.model;

import java.util.List;

public class Factura {
    private final String cedulaPaciente;
    private final String nombrePaciente;
    private final int edad;
    private final String nombreMedico;
    private final String nombreCompaniaSeguro;
    private final String numeroPoliza;
    private final String fechaVencimiento;
    private final List<ItemFactura> items;
    private final double totalServicios;
    private final double copago;
    private final double totalPaciente;
    private final double totalAseguradora;

    public Factura(String cedulaPaciente, String nombrePaciente, int edad, String nombreMedico,
                   String nombreCompaniaSeguro, String numeroPoliza, String fechaVencimiento,
                   List<ItemFactura> items, double totalServicios, double copago,
                   double totalPaciente, double totalAseguradora) {
        this.cedulaPaciente = cedulaPaciente;
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.nombreMedico = nombreMedico;
        this.nombreCompaniaSeguro = nombreCompaniaSeguro;
        this.numeroPoliza = numeroPoliza;
        this.fechaVencimiento = fechaVencimiento;
        this.items = items;
        this.totalServicios = totalServicios;
        this.copago = copago;
        this.totalPaciente = totalPaciente;
        this.totalAseguradora = totalAseguradora;
    }

    public void imprimir() {
        System.out.println("=== FACTURA CLÍNICA ===");
        System.out.println("Paciente: " + nombrePaciente + " (Edad: " + edad + ", Cédula: " + cedulaPaciente + ")");
        System.out.println("Médico tratante: " + nombreMedico);
        System.out.println("Compañía de seguro: " + nombreCompaniaSeguro);
        System.out.println("Número de póliza: " + numeroPoliza);
        System.out.println("Fecha vencimiento: " + fechaVencimiento);
        System.out.println("\n--- SERVICIOS ---");
        for (ItemFactura item : items) {
            System.out.println(item.getDescripcion() + " - $" + item.getCosto());
        }
        System.out.println("\n--- TOTALES ---");
        System.out.println("Total servicios: $" + totalServicios);
        System.out.println("Copago paciente: $" + copago);
        System.out.println("Total paciente: $" + totalPaciente);
        System.out.println("Total aseguradora: $" + totalAseguradora);
    }

    public double getTotalPaciente() { return totalPaciente; }
}
