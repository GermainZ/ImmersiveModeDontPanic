package com.germainz.immersivemodedontpanic;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class XposedMod implements IXposedHookZygoteInit {

    private final static XSharedPreferences PREFS = new XSharedPreferences("com.germainz.immersivemodedontpanic");
    private final static boolean PREF_HIDE_ALL = PREFS.getBoolean("pref_hide_all", false);

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        findAndHookMethod("com.android.internal.policy.impl.ImmersiveModeConfirmation", null, "onPowerKeyDown",
                boolean.class, long.class, boolean.class,
                XC_MethodReplacement.returnConstant(false));
        if (PREF_HIDE_ALL)
            findAndHookMethod("com.android.internal.policy.impl.ImmersiveModeConfirmation", null, "handleShow",
                    String.class, XC_MethodReplacement.returnConstant(null));
    }

}
