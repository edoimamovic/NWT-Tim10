import { Component, OnInit } from '@angular/core';
import { Show} from 'src/app/shared/show';
import { ShowService } from '../show.service';


@Component({
  selector: 'app-only-shows',
  templateUrl: './only-shows.component.html',
  styleUrls: ['./only-shows.component.css']
})
export class OnlyShowsComponent implements OnInit {
  private shows: Array<Show>;

  /*private search() {
    this.showService.search(this.searchString).subscribe(resp => {
      this.shows = resp;
    });
  }*/
  private getShows(){
    this.showService.getAllShows().subscribe(resp => { 
      this.shows=resp;
    });
  }

  constructor(private showService: ShowService ) { }


  ngOnInit() {
    this.getShows();
  }
}
