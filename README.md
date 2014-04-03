Immersive Mode, Don't Panic!
============================
Android shows you an [help message][1] when you first start an
app in Immersive Mode. When you press the 'OK' button, Android sets a flag to
remember you saw this message, and stops showing it in the future for this app.

However, Android resets this flag when a panicking user is detected. This is a
safeguard measure to help people who don't know what's happening (if they
dismissed the message without reading it.) Panicking is detected when the user
turns the screen on and off more than once within 5 seconds.
[This][2] stackoverflow answer explains this behavior in details.

This module makes [the method][3] responsible for this check do nothing, thus
removing this annoyance.
[1]: http://forum.xda-developers.com/attachment.php?attachmentid=2666673&stc=1&d=1396547244
[2]: http://stackoverflow.com/a/20309721/1460652
[3]: https://github.com/android/platform_frameworks_base/blob/master/policy/src/com/android/internal/policy/impl/ImmersiveModeConfirmation.java#L135

Download Module
===============
http://repo.xposed.info/module/com.germainz.immersivemodedontpanic

XDA Thread
==========
http://forum.xda-developers.com/showthread.php?p=51617089
