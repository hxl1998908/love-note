import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-tabset-portal',
  templateUrl: './tabset-portal.component.html',
  styleUrls: ['./tabset-portal.component.css']
})
export class TabsetPortalComponent implements OnInit {
  tabs: object[];
  selectedTab: string;
  justified: string;

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.tabs = [{id:'todos', title: 'Todos', link: '/todos'},
      {id:'surprise', title: 'Surprise', link: '/surprise'}];
    this.selectedTab = 'todos';
    this.justified = "justified";
  }

}
