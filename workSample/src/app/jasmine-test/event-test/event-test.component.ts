import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-test',
  templateUrl: './event-test.component.html',
  styleUrls: ['./event-test.component.css']
})
export class EventTestComponent implements OnInit {

  countClicks: any = 0

  constructor() { }

  ngOnInit(): void {
  }

  addClick(){
    this.countClicks = this.countClicks + 1
  }

  removeClick(){
    this.countClicks = this.countClicks - 1
  }
}
