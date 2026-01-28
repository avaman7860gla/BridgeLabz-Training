interface ReportExporter {
    void export();

    // default feature
    default void exportToJSON() {
        System.out.println("Exporting in JSON format");
    }
}

// CSV exporter
class CSVExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting in CSV format");
    }
}

// PDF exporter
class PDFExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting in PDF format");
    }
}

public class DataExportDemo {
    public static void main(String[] args) {

        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();

        csv.export();
        csv.exportToJSON();

        pdf.export();
        pdf.exportToJSON();
    }
}
