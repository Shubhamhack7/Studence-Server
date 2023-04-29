package com.tiwari.studence.util.formatter;

import com.tiwari.studence.proto.contactDetails.ISDCode;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ISDCodeFormatter implements IFormatterEnum<ISDCode> {

    @Inject
    ISDCodeFormatter() {

    }

    @Override
    public String getStringValue(ISDCode code) {
        switch (code) {

            case ISD_ONE:
                return "+1";
            case ISD_SEVEN:
                return "+7";
            case ISD_TWENTY:
                return "+20";
            case ISD_TWENTY_SEVEN:
                return "+27";
            case ISD_THIRTY:
                return "+30";
            case ISD_THIRTY_ONE:
                return "+31";
            case ISD_THIRTY_TWO:
                return "+32";
            case ISD_THIRTY_THREE:
                return "+33";
            case ISD_THIRTY_FOUR:
                return "+34";
            case ISD_THIRTY_FIVE:
                return "+35";
            case ISD_THIRTY_SIX:
                return "+36";
            case ISD_THIRTY_SEVEN:
                return "+37";
            case ISD_THIRTY_EIGHT:
                return "+38";
            case ISD_THIRTY_NINE:
                return "+39";
            case ISD_FORTY:
                return "+40";
            case ISD_FORTY_ONE:
                return "+41";
            case ISD_FORTY_TWO:
                return "+42";
            case ISD_FORTY_THREE:
                return "+43";
            case ISD_FORTY_FOUR:
                return "+44";
            case ISD_FORTY_FIVE:
                return "+45";
            case ISD_FORTY_SIX:
                return "+46";
            case ISD_FORTY_SEVEN:
                return "+47";
            case ISD_FORTY_EIGHT:
                return "+48";
            case ISD_FORTY_NINE:
                return "+49";
            case ISD_FIFTY:
                return "+50";
            case ISD_FIFTY_ONE:
                return "+51";
            case ISD_FIFTY_TWO:
                return "+52";
            case ISD_FIFTY_THREE:
                return "+53";
            case ISD_FIFTY_FOUR:
                return "+54";
            case ISD_FIFTY_FIVE:
                return "+55";
            case ISD_FIFTY_SIX:
                return "+56";
            case ISD_FIFTY_SEVEN:
                return "+57";
            case ISD_FIFTY_EIGHT:
                return "+58";
            case ISD_FIFTY_NINE:
                return "+59";
            case ISD_SIXTY:
                return "+60";
            case ISD_SIXTY_ONE:
                return "+61";
            case ISD_SIXTY_TWO:
                return "+62";
            case ISD_SIXTY_THREE:
                return "+63";
            case ISD_SIXTY_FOUR:
                return "+64";
            case ISD_SIXTY_FIVE:
                return "+65";
            case ISD_SIXTY_SIX:
                return "+66";
            case ISD_SIXTY_SEVEN:
                return "+67";
            case ISD_SIXTY_EIGHT:
                return "+68";
            case ISD_SIXTY_NINE:
                return "+69";
            case ISD_SEVENTY:
                return "+70";
            case ISD_SEVENTY_ONE:
                return "+71";
            case ISD_SEVENTY_TWO:
                return "+72";
            case ISD_SEVENTY_THREE:
                return "+73";
            case ISD_SEVENTY_FOUR:
                return "+74";
            case ISD_SEVENTY_FIVE:
                return "+75";
            case ISD_SEVENTY_SIX:
                return "+76";
            case ISD_SEVENTY_SEVEN:
                return "+77";
            case ISD_SEVENTY_EIGHT:
                return "+78";
            case ISD_SEVENTY_NINE:
                return "+79";
            case ISD_EIGHTY:
                return "+80";
            case ISD_EIGHTY_ONE:
                return "+81";
            case ISD_EIGHTY_TWO:
                return "+82";
            case ISD_EIGHTY_THREE:
                return "+83";
            case ISD_EIGHTY_FOUR:
                return "+84";
            case ISD_EIGHTY_FIVE:
                return "+85";
            case ISD_EIGHTY_SIX:
                return "+86";
            case ISD_EIGHTY_SEVEN:
                return "+87";
            case ISD_EIGHTY_EIGHT:
                return "+88";
            case ISD_EIGHTY_NINE:
                return "+89";
            case ISD_NINETY:
                return "+90";
            case ISD_NINETY_ONE:
                return "+91";
            case ISD_NINETY_TWO:
                return "+92";
            case ISD_NINETY_THREE:
                return "+93";
            case ISD_NINETY_FOUR:
                return "+94";
            case ISD_NINETY_FIVE:
                return "+95";
            case ISD_NINETY_SIX:
                return "+96";
            case ISD_NINETY_SEVEN:
                return "+97";
            case ISD_NINETY_EIGHT:
                return "+98";
            case UNRECOGNIZED:
                ISDCode.UNRECOGNIZED.name();

            default:
                throw new IllegalStateException("Unexpected value: " + code);
        }
    }

    @Override
    public ISDCode getEnum(String S) {
        return null;
    }
}
