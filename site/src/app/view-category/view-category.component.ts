import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { VideoService } from '../video.service';
import { Video } from '../shared/video';

@Component({
  selector: 'app-view-category',
  templateUrl: './view-category.component.html',
  styleUrls: ['./view-category.component.css']
})
export class ViewCategoryComponent implements OnInit {
  private searchString='';
  private categoryName: string;
  private videos: Array<Video>;

  constructor(private route: ActivatedRoute,
              private videoService: VideoService) { }

  private searchcategory() {
    this.route.params.subscribe(params => {
      this.categoryName = params['category'];
      this.videoService.searchcategory(this.searchString,this.categoryName).subscribe(resp => {
      this.videos = resp;
    });
  });
  }
       
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.categoryName = params['category'];
      this.videoService.getVideosByCategory(this.categoryName).subscribe(videos => { 
        this.videos = videos;
       
      }); 

    }); this.searchcategory();
    
  }
}
