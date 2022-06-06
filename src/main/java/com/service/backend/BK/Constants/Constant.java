package com.service.backend.BK.Constants;

public class Constant {

    // Quality constants
    public enum Quality{
        //no graad need for request item
        NOGRAD("No Grad Need"),
        //Major Damange outside AND inside, wornt out, JUNK
        HEAVYDMN("Heavy Damanged"),
        //Missing majority Items,Damanged, booklet not complete but working
        LOOSE("Loose"),
        //Damanged outside and inside, missing few items working
        POOR("Poor"),
        // minor damange, minor item missing, working
        LIGHTDMN("Light Damanged or Played"),
        // minor damange but complete, working
        GOOD("Good"),
        // extremely minor damange, complete, working
        EXCELENT("Excellent"),
        // used, nothing missing
        NEARMINT("Near Mint"),
        // brand as new, completed, not used
        MINT("Mint"),
        // new from shop, not used
        NEWUNRL("New From Source")
        ;
        public final String label;
        private Quality(String label) {
            this.label=label;
        }
    }
}
