declare module '@apiverve/utmconverter' {
  export interface utmconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface utmconverterResponse {
    status: string;
    error: string | null;
    data: UTMCoordinateConverterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface UTMCoordinateConverterData {
      conversion: null | string;
      input:      Input;
      output:     Output;
      formatted:  null | string;
      datum:      null | string;
  }
  
  interface Input {
      latitude:  number | null;
      longitude: number | null;
  }
  
  interface Output {
      zone:       number | null;
      hemisphere: null | string;
      easting:    number | null;
      northing:   number | null;
  }

  export default class utmconverterWrapper {
    constructor(options: utmconverterOptions);

    execute(callback: (error: any, data: utmconverterResponse | null) => void): Promise<utmconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: utmconverterResponse | null) => void): Promise<utmconverterResponse>;
    execute(query?: Record<string, any>): Promise<utmconverterResponse>;
  }
}
