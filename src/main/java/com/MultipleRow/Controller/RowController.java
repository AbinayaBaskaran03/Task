package com.MultipleRow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MultipleRow.Entity.RowEntity;
import com.MultipleRow.Service.RowService;

@RestController
@RequestMapping("/api/row")
public class RowController {

	@Autowired
	private RowService rowService;

	@PostMapping(value = "/create")
	public ResponseEntity<String> create(@RequestBody RowEntity row) {
		rowService.createRecord(row);
		return ResponseEntity.ok("Record created successfully");
	}

	@GetMapping(value = "/getFirst5rows")
	public List<RowEntity> getFirst5Rows() {
		return rowService.getFirst5Rows();
	}

}
