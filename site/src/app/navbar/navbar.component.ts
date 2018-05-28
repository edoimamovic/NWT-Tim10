import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/auth.service';
import { VideoService } from '../video.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private categories: Array<object>;

  constructor(private authService: AuthService, 
              private videoService: VideoService) { }

  ngOnInit() {
    this.videoService.getCategories().subscribe(categories => { 
      this.categories = categories;
    });
  }
}
