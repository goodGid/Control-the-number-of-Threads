package dev.be.goodgid.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.be.goodgid.entity.RequestDto;
import dev.be.goodgid.service.ReconcileService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReconcileController {

    private final ReconcileService reconcileService;

    @GetMapping("/reconcile")
    public void reconcile() {
        List<RequestDto> requestDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            requestDtoList.add(new RequestDto());
        }
        int maxPoolSize = 5;
        reconcileService.reconcile(requestDtoList, maxPoolSize);
    }
}
