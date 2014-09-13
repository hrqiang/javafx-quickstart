javafx-quickstart
=================

A JavaFX starter project that uses Zen Java maven plugin.

FXM file build from scene builder 2.0 with CSS schema.

Original pom and source code is from
https://github.com/plusjeff/hello-fx
and css schema is from
https://github.com/GreggSetzer/JavaFX-CSS-Themes

This also demo a long-running task to update UI in another thread.

If you are new to JavaFX, this project may useful to you.
I'll create archetype as well.

Useful maven commands.

$ mvn jfx:run
Run this application.

$ mvn jfx:native
Create native apps. Build dmg for mac, linux package or exe file for windows.

$ mvn jfx:jar
Build runnable jar file.
