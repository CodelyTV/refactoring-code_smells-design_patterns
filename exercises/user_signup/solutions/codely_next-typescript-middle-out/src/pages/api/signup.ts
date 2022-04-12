import { NextApiRequest, NextApiResponse } from "next/types";

export default async (request: NextApiRequest, httpResponse: NextApiResponse): Promise<void> => {
  if (request.method !== "POST") {
    httpResponse.status(404).end();

    return;
  };

  if (request.body.name.length < 2) {
    httpResponse.status(403).end();
  }
  
  httpResponse.status(200).end();
}
