package com.revature.cmChicken.util.logging;

import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.Log;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.time.LocalDateTime;

public class Logger {


    private static Logger logger;
    private final boolean printToConsole;

    private Logger(boolean printToConsole) {
        this.printToConsole = printToConsole;
    }

    public static Logger getLogger(){
        if(logger == null){
            logger = new Logger(true);
        }
        return logger;
    }

    public static Logger getLogger(boolean printToConsole){
        if(logger == null){
            logger = new Logger(printToConsole);
        }
        return logger;
    }

    public void log(String message){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL file = loader.getResource("cmChicken.log");

        try(Writer logWriter = new FileWriter(String.valueOf(file).split(":")[1], true);){
            logWriter.write(LocalDateTime.now().toString() + "LOG: " + message + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void info(String message){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL file = loader.getResource("cmChicken.log");

        try(Writer logWriter = new FileWriter(String.valueOf(file).split(":")[1], true);){
            logWriter.write(LocalDateTime.now().toString() + "INFO: " + message + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void debug(String message){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL file = loader.getResource("cmChicken.log");

        try(Writer logWriter = new FileWriter(String.valueOf(file).split(":")[1], true);){
            logWriter.write(LocalDateTime.now().toString() + "DEBUG: " + message + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void warn(String message){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL file = loader.getResource("cmChicken.log");

        try(Writer logWriter = new FileWriter(String.valueOf(file).split(":")[1], true);){
            logWriter.write(LocalDateTime.now().toString() + "WARN: " + message + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
