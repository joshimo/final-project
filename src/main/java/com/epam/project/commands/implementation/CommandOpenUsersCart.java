package com.epam.project.commands.implementation;

import com.epam.project.commands.ICommand;
import com.epam.project.config.Configuration;
import com.epam.project.controller.Direction;
import com.epam.project.controller.ExecutionResult;
import com.epam.project.controller.SessionRequestContent;

public class CommandOpenUsersCart implements ICommand {

    @Override
    public ExecutionResult execute(SessionRequestContent content) {
        Configuration conf = Configuration.getInstance();
        ExecutionResult result = new ExecutionResult();
        result.setDirection(Direction.FORWARD);
        try {
            result.setPage(conf.getPage("usersCart"));
        }
        catch (NullPointerException uue) {
            result.addRequestAttribute("errorMessage", conf.getErrorMessage("showUserCartErr"));
            result.setPage(conf.getPage("error"));
        }
        return result;
    }

}
