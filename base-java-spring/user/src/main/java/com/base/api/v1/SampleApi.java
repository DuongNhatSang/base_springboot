//package com.base.api.v1;
//
//import com.base.dto.v1.response.SampleRes;
//import com.base.mapper.v1.SampleMapper;
//import com.base.service.v1.SampleService;
//import com.base.util.paging.PaginationUtils;
//import com.base.dto.v1.response.ListResponse;
//import com.base.model.Sample;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/samples")
//public class SampleApi {
//    private final SampleService sampleService;
//
//    public SampleApi(final SampleService sampleService) {
//        this.sampleService = sampleService;
//    }
//
//    @GetMapping
//    public ResponseEntity<?> fetchSamples() {
//        List<Sample> samples = sampleService.fetchSamples();
//        return ResponseEntity.ok(new ListResponse<>(SampleMapper.INSTANCE.toSampleResList(samples)));
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<?> searchSamples(@RequestParam(required = false) final Map<String, String> requestParams) {
//        String keyword = requestParams.get("keyword");
//        PageRequest pageRequest = PaginationUtils.generatePageRequest(requestParams);
//
//        Page<SampleRes> samples = sampleService.searchSamples(pageRequest, keyword)
//                                               .map(SampleMapper.INSTANCE::toSampleRes);
//
//        return ResponseEntity.ok(PaginationUtils.buildPageRes(samples));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getSample(@PathVariable final Long id) {
//        Sample sample = sampleService.getSample(id);
//        return ResponseEntity.ok(SampleMapper.INSTANCE.toSampleDetailRes(sample));
//    }
//}
