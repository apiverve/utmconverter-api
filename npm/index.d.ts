declare module '@apiverve/utmconverter' {
  export interface utmconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface utmconverterResponse {
    status: string;
    error: string | null;
    data: UTMCoordinateConverterData;
    code?: number;
  }


  interface UTMCoordinateConverterData {
      conversion: string;
      input:      Input;
      output:     Output;
      formatted:  string;
      datum:      string;
  }
  
  interface Input {
      latitude:  number;
      longitude: number;
  }
  
  interface Output {
      zone:       number;
      hemisphere: string;
      easting:    number;
      northing:   number;
  }

  export default class utmconverterWrapper {
    constructor(options: utmconverterOptions);

    execute(callback: (error: any, data: utmconverterResponse | null) => void): Promise<utmconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: utmconverterResponse | null) => void): Promise<utmconverterResponse>;
    execute(query?: Record<string, any>): Promise<utmconverterResponse>;
  }
}
