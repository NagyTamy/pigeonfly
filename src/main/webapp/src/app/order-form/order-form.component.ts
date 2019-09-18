import { Component, OnInit } from '@angular/core';
import {Pigeon} from 'src/main/webapp/src/app/model/pigeons';
import {PigeonService} from "../service/pigeon-service.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FormGroup, FormControl } from '@angular/forms';
import {createUser, User} from "../model/user";
import {UserService} from "../service/user-service.service";


@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit{
  pigeons: Pigeon[];

  constructor(private pigeonService: PigeonService, private http: HttpClient, private userService: UserService) {
  }

  orderForm = new FormGroup({
  name: new FormControl(''),
  eMail: new FormControl(''),
  pickUpCountry: new FormControl(''),
  pickUpCity: new FormControl('',),
  pickUpAddress: new FormControl(''),
  deliveryCountry: new FormControl(''),
  deliveryCity: new FormControl(''),
  deliveryAddress: new FormControl(''),
  pigeonName: new FormControl('')});


  ngOnInit() {
    this.pigeonService.findAll().subscribe(data => {
      this.pigeons = data;
    });
  }

  private orderUrl: 'http://localhost:8080/user';

  onSubmit() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');


    this.http.post('http://localhost:8080/order', this.orderForm.value)
      .subscribe((res) => {
        alert(res);
    confirm("Order sent!");
    this.userService.save(this.orderForm.value);
  })};


  updatePigeonName(pigeon) {
    this.orderForm.patchValue({
      pigeonName: pigeon.isAvailable
    })
  }

}
