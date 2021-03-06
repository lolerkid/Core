package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Prayer;

import static org.parabot.atex.dreamscape.ainstancefighter.data.Methods.getPrayer;

public class Pray implements Strategy {
    @Override
    public boolean activate() {
        if(getPrayer() == 0) return false;
        for(Prayer.Curse c : Core.getSettings().getCurses()) {
            if(!Prayer.isEnabled(c)) return true;
        }
        return false;
    }

    @Override
    public void execute() {
        for(Prayer.Curse c : Core.getSettings().getCurses()) {
            Prayer.enable(c);
            Time.sleep(1000);
        }
    }
}
