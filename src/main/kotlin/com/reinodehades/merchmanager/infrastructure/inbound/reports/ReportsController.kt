package com.reinodehades.merchmanager.infrastructure.inbound.reports

import com.reinodehades.merchmanager.application.reports.ReportService
import com.reinodehades.merchmanager.domain.model.ProductStockReport
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/report")
class ReportController(private val reportService: ReportService) {

    @GetMapping("/csv", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun getCsvReport(): ResponseEntity<String> {
        val csv = reportService.generateCsvReport()
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=stock_report.csv")
            .body(csv)
    }

    @GetMapping
    fun getJsonReport(): List<ProductStockReport> = reportService.generateReport()
}