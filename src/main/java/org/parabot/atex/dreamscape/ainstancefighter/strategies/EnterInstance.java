package org.parabot.atex.dreamscape.ainstancefighter.strategies;

import org.parabot.atex.dreamscape.ainstancefighter.core.Core;
import org.parabot.atex.dreamscape.ainstancefighter.data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Interfaces;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;

public class EnterInstance implements Strategy {
    @Override
    public boolean activate() {
        return SceneObjects.getClosest(Constants.INSTANCE_PORTAL_ID) != null
                || Interfaces.getOpenInterfaceId() == Constants.SELECT_INSTANCE_INTERFACE_ID;
    }

    @Override
    public void execute() {
        if(Interfaces.getOpenInterfaceId() != Constants.SELECT_INSTANCE_INTERFACE_ID) {
            SceneObjects.getClosest(Constants.INSTANCE_PORTAL_ID).interact(SceneObjects.Option.OPEN);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Interfaces.getOpenInterfaceId() == Constants.SELECT_INSTANCE_INTERFACE_ID;
                }
            }, 3000);
        }
        if(Interfaces.getOpenInterfaceId() == Constants.SELECT_INSTANCE_INTERFACE_ID) {
            Time.sleep(1000);
            Menu.clickButton(Core.getSettings().getSelectedBoss().getButtonId());
            Time.sleep(1500);
            Menu.clickButton(43617);
            Time.sleep(1000);
        }
    }
}
