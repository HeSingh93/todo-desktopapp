package com.example.todo.controllers;

import Entities.EmployeeEntity;
import Entities.WorkOrderEntity;
import java.util.HashMap;

public class WorkOrder {
    private HashMap<EmployeeEntity, WorkOrderEntity> workOrders;

    public WorkOrder() {
        this.workOrders = new HashMap<>();
    }

    public void addWorkOrder(EmployeeEntity employeeEntity, WorkOrderEntity workOrderEntity) {
        this.workOrders.putIfAbsent(employeeEntity, workOrderEntity);
    }

    public void updateWorkOrder() {
        //todo: add functionality
    }

    public void removeWorkOrder(EmployeeEntity employeeEntity, WorkOrderEntity workOrderEntity) {
        this.workOrders.remove(employeeEntity, workOrderEntity);
    }

    public String toString() {
        return this.workOrders.toString();
    }
}
