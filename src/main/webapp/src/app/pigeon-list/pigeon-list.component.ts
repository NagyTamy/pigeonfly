import { Component, OnInit } from '@angular/core';
import {Pigeon} from 'src/main/webapp/src/app/model/pigeons';
import {PigeonService} from "../service/pigeon-service.service";

@Component({
  selector: 'app-pigeon-list',
  templateUrl: './pigeon-list.component.html',
  styleUrls: ['./pigeon-list.component.css']
})
export class PigeonListComponent implements OnInit {

  pigeons: Pigeon[];

  constructor(private pigeonService: PigeonService) {
  }

  ngOnInit() {
    this.pigeonService.findAll().subscribe(data => {
      this.pigeons = data;
    });
  }


}
