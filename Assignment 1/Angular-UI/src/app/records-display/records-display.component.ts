import { Component, OnInit } from '@angular/core';
import { RecordsDisplayService } from '../service/records-display.service';

@Component({
  selector: 'app-records-display',
  templateUrl: './records-display.component.html',
  styleUrls: ['./records-display.component.css']
})
export class RecordsDisplayComponent implements OnInit {

  records: Array<any> = []
  dataSource: any = []

  constructor(private service: RecordsDisplayService) { }

  ngOnInit(): void {
    this.service.getStudentDetails()
                .subscribe( data => {
                    this.records = data
                    this.dataSource = this.records
                  }
                )
  }
}
