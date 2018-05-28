import { Component, OnInit } from '@angular/core';
import { VideoService } from '../video.service';
import { Video } from 'src/app/shared/video';

@Component({
  selector: 'app-browse-videos',
  templateUrl: './browse-videos.component.html',
  styleUrls: ['./browse-videos.component.css']
})
export class BrowseVideosComponent implements OnInit {
  private searchString = '';
  private videos: Array<Video>;
  public testVideo: Video;

  private search() {
    this.videoService.search(this.searchString).subscribe(resp => {
      this.videos = resp;
    });
  }

  constructor(private videoService: VideoService) { }

  ngOnInit() {
    this.search();

    this.testVideo = new Video({
      id: "1",
      title: "test",
      uploadedBy: "john",
      uploadDate: "",
      videoData: "",
      url: "test url",
      thumbnailUrl: "test url",
      description: "description"
    });
  }
}
