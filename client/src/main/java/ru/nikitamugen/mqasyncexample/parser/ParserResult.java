package ru.nikitamugen.mqasyncexample.parser;

import java.util.List;

public class ParserResult {

    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String GET = "get";
    public static final String HELP = "help";
    public static final String EXIT = "exit";
    public static final String UNKNOWN = "unknown";

    public String command;
    public Boolean needHelp;
    public Boolean needExit;
    public String code;
    public List<String> values;

    public ParserResult() {
        this.needExit = false;
        this.needHelp = false;
    }

    @Override
    public String toString() {
        return "ParserResult{" +
                "command='" + command + '\'' +
                ", needHelp=" + needHelp +
                ", needExit=" + needExit +
                ", code='" + code + '\'' +
                ", values=" + values +
                '}';
    }
}
