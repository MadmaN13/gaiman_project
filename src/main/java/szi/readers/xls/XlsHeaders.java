package szi.readers.xls;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class XlsHeaders {

    public enum ThreatXlsHeader {
        ID(0),
        NAME(1),
        POSSIBILITY(2),
        HAZARD(3)
        ;
        private int columnIndex;
        private ThreatXlsHeader(int value) {
            this.columnIndex = value;
        }
        public int getColumnIndex() {return this.columnIndex;}
    }

    public enum ModuleXlsHeader {
        ID(0),
        NAME(1),
        THREAT_IDS(2),
        ;
        private int columnIndex;
        private ModuleXlsHeader(int value) {
            this.columnIndex = value;
        }
        public int getColumnIndex() {return this.columnIndex;}
    }

    public enum IsmXlsHeader {
        ID(0),
        NAME(1),
        COST(2),
        THREAT_IDS(3)
        ;
        private int columnIndex;
        private IsmXlsHeader(int value) {
            this.columnIndex = value;
        }
        public int getColumnIndex() {return this.columnIndex;}
    }
}
