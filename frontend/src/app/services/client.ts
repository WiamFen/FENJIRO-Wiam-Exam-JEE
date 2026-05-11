import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Client {}
@Injectable({ providedIn: 'root' })
export class ClientService {

  private api = 'http://localhost:8085/api/clients';

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<any[]>(this.api);
  }

  add(client: any) {
    return this.http.post(this.api, client);
  }
}
