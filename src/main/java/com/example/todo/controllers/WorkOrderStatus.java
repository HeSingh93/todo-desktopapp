package com.example.todo.controllers;

public class WorkOrderStatus {
    public static final int UNASSIGNED = 1;
    public static final int ASSIGNED = 2;
    public static final int ACCEPTED = 3;
    public static final int DONE = 4;

    public static String getStatus(int status) {
        String workOrderStatus = "";
        switch (status) {
            case 1:
                workOrderStatus = "Unassigned";
                break;

            case 2:
                workOrderStatus = "Assigned";
                break;

            case 3:
                workOrderStatus = "Accepted";
                break;

            case 4:
                workOrderStatus = "Done";
                break;
        }

        return workOrderStatus;
    }
}
