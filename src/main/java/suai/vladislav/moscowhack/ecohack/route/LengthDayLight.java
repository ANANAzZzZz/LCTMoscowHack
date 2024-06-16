package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;

public enum LengthDayLight {
    January(7),
    February(9),
    March(12),
    April(14),
    May(16),
    June(17),
    July(16),
    August(14),
    September(12),
    October(11),
    November(9),
    December(8);

    public final Integer length;

    private LengthDayLight(Integer length) {
        this.length = length;
    }
}
