import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../services/client';

@Component({
  selector: 'app-client',
  imports: [],
  templateUrl: './client.html',
  styleUrl: './client.css',
})

export class Client implements OnInit {

  clients: any;

  constructor(private service: ClientService) {}

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.clients = data;
    });
  }
}
