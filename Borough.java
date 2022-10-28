
/**
 * Enumeration class Borough - cotaines all borough abbreviations, as seen on map, and will return corresponding
 * full string value
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
enum Borough
{
    ENFI, BARN, HRGY, WALT, HRRW, BREN, CAMD, ISLI,
    HACK, REDB, HAVE, HILL, EALI, KENS, WSTM, TOWH, NEWH, BARK, HOUN,
    HAMM, WAND, CITY ,GWCH, BEXL, RICH, MERT, LAMB, STWH, LEWS, KING,
    SUTT, CROY, BROM;
}

/**
 * this class will return the string value of the 4 letter abbreaviations of the borough
 */
class BoroughName {
    public static String get(Borough borough) {
        switch (borough) {
            case ENFI: return "Enfield";
            case BARN: return "Barnet";
            case HRGY: return "Haringey";
            case WALT: return "Waltham Forest";
            case HRRW: return "Harrow";
            case BREN: return "Brent";
            case CAMD: return "Camden";
            case ISLI: return "Islington";
            case HACK: return "Hackney";
            case REDB: return "Redbridge";
            case HAVE: return "Havering";
            case HILL: return "Hillingdon";
            case EALI: return "Ealing";
            case KENS: return "Kensington and Chelsea";
            case WSTM: return "Westminster";
            case TOWH: return "Tower Hamlets";
            case NEWH: return "Newham";
            case BARK: return "Barking and Dagenham";
            case HOUN: return "Hounslow";
            case HAMM: return "Hammersmith and Fulham";
            case WAND: return "Wandsworth";
            case CITY: return "City of London";
            case GWCH: return "Greenwich";
            case BEXL: return "Bexley";
            case RICH: return "Richmond upon Thames";
            case MERT: return "Merton";
            case LAMB: return "Lambeth";
            case STWH: return "Southwark";
            case LEWS: return "Lewisham";
            case KING: return "Kingston upon Thames";
            case SUTT: return "Sutton";
            case CROY: return "Croydon";
            case BROM: return "Bromley";
            default: return null;
        }
    }
}

