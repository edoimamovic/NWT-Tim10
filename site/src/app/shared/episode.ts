export class Episode {
    public id: number;
    public season: number;
    public number: number;
    public title: string;
    public show: object;
    public video: object; 
;
  constructor(data) {
        if (data) {
            this.id = data.id;
            this.title = data.title;
            this.number= data.number;
            this.season = data.season;
            this.show = data.show;
            this.video= data.video;
            
           
        }
    }
}
